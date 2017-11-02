sbt-filter
==========

[sbt-web](https://github.com/sbt/sbt-web) plugin that filters intermediate assets on the asset pipeline.

This plugin may be used to remove any intermediate or unnecessary assets from the product build of your project.
Only assets directly owned by the project can be filtered. Any assets living in the "lib" subdirectory are
explicitly left unfiltered.

Add the plugin to the `project/plugins.sbt` of your project:

```scala
addSbtPlugin("com.slidingautonomy.sbt" % "sbt-filter" % "1.0.1")
```

Your project's build file also needs to enable sbt-web plugins. For example with build.sbt:

```scala
lazy val root = (project in file(".")).enablePlugins(SbtWeb)
```

The plugin must then be added as a new stage in the asset pipeline.

```scala
pipelineStages := Seq(filter)
```

## File Filters

By default, the plugin allows all assets to pass through the pipeline. To filter assets, you must explicitly configure
the includeFilter and excludeFilter to match your requirements.

Any asset matched by the includeFilter will be filtered from the build, unless it also matches the exclude filter.
Because filtering is a negative action, the sense of the includeFilter and excludeFilter may seem reversed. Remember
that the includeFilter selects assets to be filtered while the excludeFilter removes assets from the list of assets
that will be filtered.

For example, to remove the original CoffeeScript and LESS sources from the assets build:

```scala
includeFilter in filter := "*.coffee" || "*.less"
```

Alternatively, you may wish to remove all JavaScript files except the concatenated and minified main.js produced by
the RequireJS plugin:

```scala
includeFilter in filter := "*.js"

excludeFilter in filter := "main.js"
```

You can also remove a folder and all of its contents (including sub-folders). e.g. the "javascripts/working" folder and its contents with:

```scala
includeFilter in filter := PathFilter((sourceDirectory in Assets).value / "javascripts" / "working")
```
