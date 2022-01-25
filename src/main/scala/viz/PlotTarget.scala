package viz


import java.io.{ File, PrintWriter }
import java.awt.Desktop
import almond.api.JupyterApi
import almond.interpreter.api.DisplayData
import almond.api.JupyterAPIHolder.value
import java.nio.file.Paths
import java.nio.file.Files
import viz.websockets.WebsocketVizServer
import scala.concurrent.Future

implicit val ec: scala.concurrent.ExecutionContext = scala.concurrent.ExecutionContext.global

trait PlotTarget:
  def show(spec: String): Unit

object PlotTargets:

  lazy val conf = org.ekrich.config.ConfigFactory.load()
  lazy val outPath: Option[String] = {
    val pathIsSet: Boolean = conf.hasPath("dedavOutPath")
    if pathIsSet then
      Some(conf.getString("dedavOutPath"))
    else
      None
  }

  given doNothing: PlotTarget with
    override def show(spec: String) = ()

  given printlnTarget: PlotTarget with
    override def show(spec: String) = println(spec)

  given desktopBrowser: PlotTarget with    
    override def show(spec: String) = {        
        val theHtml = raw"""<!DOCTYPE html>
        <html>
        <head>
        <meta charset="utf-8" />
        <!-- Import Vega & Vega-Lite -->
        <script src="https://cdn.jsdelivr.net/npm/vega@5"></script>
        <script src="https://cdn.jsdelivr.net/npm/vega-lite@5"></script>
        <!-- Import vega-embed -->
        <script src="https://cdn.jsdelivr.net/npm/vega-embed@5"></script>
        <style>
            div#vis {
                width: 95vmin;
                height:95vmin;
                style="position: fixed; left: 0; right: 0; top: 0; bottom: 0"
            }
        </style>
        </head>
        <body>            
            <div id="vis"></div>

        <script type="text/javascript">
        const spec = ${spec};  
         vegaEmbed('#vis', spec, {
            renderer: "canvas", // renderer (canvas or svg)
            container: "#vis", // parent DOM container
            hover: true, // enable hover processing
            actions: {
              editor : true
            }
        }).then(function(result) {

        })
        </script>
        </body>
        </html> """        
        val tempFi = outPath match
          case Some(path) => 
            os.temp(theHtml, dir = os.Path(path), suffix=".html", prefix="plot-")
          case None => 
            os.temp(theHtml, suffix=".html", prefix="plot-")
        Desktop.getDesktop().browse(tempFi.toNIO.toUri())
    }

/*   given vsCodeNotebook: PlotTarget with
    override def show(spec: String)(using kernel: JupyterApi) = almond.show(spec)  */

  given almond: PlotTarget with
    override def show(spec: String) =   
      val kernel = summon[JupyterApi]                 
      kernel.publish.display(
          DisplayData(
            data = Map(      
              "application/vnd.vega.v5+json" -> spec
            )
          )  
        )
 
  given websocket: PlotTarget with
    override def show(spec: String) = 
      if WebsocketVizServer.firstTime then
        println("here")
        val port = WebsocketVizServer.randomPort
        Desktop.getDesktop().browse(java.net.URI(s"http://localhost:$port"))        
        Thread.sleep(1000) // give undertow a chance to start
        requests.post(s"http://localhost:$port/viz", data=spec)
        
      else
        val port = WebsocketVizServer.randomPort
        requests.post(s"http://localhost:$port/viz", data=spec)

  given png: PlotTarget with
    override def show(spec: String) : Unit = 
      val pngBytes = os.proc("vg2png").call(stdin = spec )
      pngBytes.exitCode match 
        case 0 => 
          outPath match
            case Some(path) => 
              os.temp(pngBytes.out.bytes, dir = os.Path(path), deleteOnExit = false, suffix=".png", prefix="plot-" )
            case None => 
              os.temp(pngBytes.out.bytes, deleteOnExit = false, suffix=".png", prefix="plot-")
        case _ => throw new Exception(pngBytes.err.text())
  
  given pdf: PlotTarget with
    override def show(spec: String) : Unit = 
      val pngBytes = os.proc("vg2pdf").call(stdin = spec )
      pngBytes.exitCode match 
        case 0 => 
          outPath match
            case Some(path) => 
              os.temp(pngBytes.out.bytes, dir = os.Path(path), deleteOnExit = false, suffix=".html", prefix="plot-" )
            case None => 
              os.temp(pngBytes.out.bytes, deleteOnExit = false, suffix=".pdf", prefix="plot-")
        case _ => throw new Exception(pngBytes.err.text())

  given svg: PlotTarget with
    override def show(spec: String) : Unit = 
      val pngBytes = os.proc("vg2svg").call(stdin = spec )
      pngBytes.exitCode match 
        case 0 => 
          outPath match
            case Some(path) => 
              os.temp(pngBytes.out.bytes, dir = os.Path(path), deleteOnExit = false, suffix=".html", prefix="plot-" )
            case None => 
              os.temp(pngBytes.out.bytes, deleteOnExit = false, suffix=".svg", prefix="plot-")
        case _ => throw new Exception(pngBytes.err.text())