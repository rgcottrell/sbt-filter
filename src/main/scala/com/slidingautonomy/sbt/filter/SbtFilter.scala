package com.slidingautonomy.sbt.filter

import sbt._
import sbt.Keys._
import com.typesafe.sbt.jse.SbtJsTask
import com.typesafe.sbt.web.pipeline.Pipeline

object Import {

  val filter = TaskKey[Pipeline.Stage]("filter", "Filter intermediate files on the asset pipeline.")

}

object SbtFilter extends AutoPlugin {

  override def requires = SbtJsTask

  override def trigger = AllRequirements

  val autoImport = Import

  import autoImport._

  override def projectSettings = Seq(
    filter := runFilter.value,
    includeFilter in filter := NothingFilter,
    excludeFilter in filter := NothingFilter
  )

  private def runFilter: Def.Initialize[Task[Pipeline.Stage]] = Def.task {
    mappings =>

      val include = (includeFilter in filter).value
      val exclude = (excludeFilter in filter).value
      mappings.filter {
        case (file, path) =>
          !include.accept(file) || exclude.accept(file) || path.startsWith("lib" + java.io.File.separator)
      }
  }

}
