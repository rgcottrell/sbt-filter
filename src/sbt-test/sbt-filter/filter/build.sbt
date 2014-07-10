lazy val root = (project in file(".")).enablePlugins(SbtWeb)

includeFilter in filter := "*.coffee" || "*.map"

pipelineStages := Seq(filter)
