lazy val root = (project in file(".")).enablePlugins(SbtWeb)

includeFilter in filter := PathFilter((sourceDirectory in Assets).value / "javascripts" / "working")

pipelineStages := Seq(filter)
