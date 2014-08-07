lazy val root = (project in file(".")).enablePlugins(SbtWeb)

includeFilter in filter := "temp" || "*.coffee"

pipelineStages := Seq(filter)
