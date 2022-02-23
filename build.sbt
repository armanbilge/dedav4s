import laika.helium.Helium
import laika.helium.config.HeliumIcon
import laika.helium.config.IconLink
import laika.ast.Path.Root
import laika.theme.config.Color
import java.time.Instant

Global / onChangedBuildSource := ReloadOnSourceChanges
import java.io.File
inThisBuild(
  List(
    scalaVersion := "3.1.0",
    semanticdbEnabled := true,
    semanticdbVersion := scalafixSemanticdb.revision
  )
)

ThisBuild / tlSitePublishBranch := Some("main")
ThisBuild / tlBaseVersion := "0.4"
ThisBuild / organization := "io.github.quafadas"
ThisBuild / organizationName := "quafadas"
ThisBuild / licenses := Seq(License.Apache2)
ThisBuild / developers := List(
  // your GitHub handle and name
  tlGitHubDev("quafadas", "Simon Parten")
)
ThisBuild / tlSonatypeUseLegacyHost := false

ThisBuild / scalaVersion := "3.1.0"

lazy val root = project
  .in(file("."))
  .settings(
    name := "dedav4s",
    description := "Declarative data viz for scala",
    libraryDependencies ++= Seq(
      "com.lihaoyi" %% "upickle" % "1.4.3",
      "com.lihaoyi" %% "requests" % "0.7.0",
      "com.lihaoyi" %% "cask" % "0.8.0",
      "com.lihaoyi" %% "scalatags" % "0.11.1",
      "com.lihaoyi" %% "os-lib" % "0.8.0",
      "org.ekrich" %% "sconfig" % "1.4.4", // otherwise have to upgrade scala
      //"com.github.jupyter" % "jvm-repr" %  "0.4.0",
      ("sh.almond" % "scala-kernel-api" % "0.11.2" % Provided)
        .cross(CrossVersion.for3Use2_13With("", ".4"))
        .exclude("com.lihaoyi", "geny_2.13")
        .exclude("com.lihaoyi", "sourcecode_2.13")
        .exclude("com.lihaoyi", "fansi_2.13")
        .exclude("com.lihaoyi", "os-lib_2.13")
        .exclude("com.lihaoyi", "pprint_2.13")
        .exclude("org.scala-lang.modules", "scala-collection-compat_2.13")
        .exclude("com.github.jupyter", "jvm-repr"),
      "org.jsoup" % "jsoup" % "1.14.3",
      "org.scalameta" %% "munit" % "0.7.29" % Test
    )
  )

lazy val jsdocs = project
  .in(file("jsdocs"))
  .settings(
    libraryDependencies += "org.scala-js" %%% "scalajs-dom" % "2.1.0"
  )
  .enablePlugins(ScalaJSPlugin)

lazy val docs = project
  .in(file("myproject-docs")) // important: it must not be docs/
  .settings(
    mdocJS := Some(jsdocs),
    //mdocOut := new File("docs"),
    mdocIn := new File("rawDocs"),
    mdocVariables ++= Map(
      "js-batch-mode" -> "true",
      "js-html-header" ->
        """
<script crossorigin type="text/javascript" src="https://cdn.jsdelivr.net/npm/vega@5"></script>
<script crossorigin type="text/javascript" src="https://cdn.jsdelivr.net/npm/vega-lite@5"></script>
<script crossorigin type="text/javascript" src="https://cdn.jsdelivr.net/npm/vega-embed@6"></script>
"""
    ),
    libraryDependencies ++= Seq(
      ("org.scalanlp" %% "breeze" % "2.0").exclude("org.scala-lang.modules", "scala-collection-compat_2.13")
    ),
    laikaConfig ~= { _.withRawContent },
    tlSiteHeliumConfig ~= {
      // Actually, this *disables* auto-linking, to avoid duplicates with mdoc
      _.site.autoLinkJS()
    },
    laikaTheme := tlSiteHeliumConfig.value.all
      .metadata(
        title = Some("Project Name"),
        language = Some("en"),
        description = Some("Declarative data visualisation for scala"),
        authors = Seq("Simon Parten"),
        date = Some(Instant.now)
      )
      .site
      .darkMode
      .themeColors(
        primary = Color.hex("1c44b2"),
        secondary = Color.hex("b26046"),
        primaryMedium = Color.hex("2962ff"),
        primaryLight = Color.hex("e6f4f3"),
        text = Color.hex("000000"),
        background = Color.hex("ffffff"),
        bgGradient = (Color.hex("3788ac"), Color.hex("fff5e6"))
      )
      .site
      .themeColors(
        primary = Color.hex("3788ac"),
        secondary = Color.hex("b26046"),
        primaryMedium = Color.hex("2962ff"),
        primaryLight = Color.hex("fff5e6"),
        text = Color.hex("000000"),
        background = Color.hex("ffffff"),
        bgGradient = (Color.hex("3788ac"), Color.hex("fff5e6"))
      )
      .site
      .topNavigationBar(
        homeLink = IconLink.internal(Root / "README.md", HeliumIcon.home),
        navLinks = Seq(IconLink.external("https://github.com/Quafadas/dedav4s", HeliumIcon.github)),
        highContrast = false
      )
      .build
  )
  .dependsOn(root)
  .enablePlugins(TypelevelSitePlugin)
