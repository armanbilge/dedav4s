package viz

import ujson.Value
import java.net.URI

trait FromFile extends WithBaseSpec {

    lazy val path : String = ???

    override lazy val baseSpec = scala.io.Source.fromFile(path).mkString("")    
}