sbtPlugin := true

organization := "com.slidingautonomy.sbt"

name := "sbt-filter"

version := "1.0.2-SNAPSHOT"

crossSbtVersions := Seq("1.0.2", "0.13.16")

scalacOptions += "-feature"

resolvers ++= Seq(
  "Typesafe Releases Repository" at "http://repo.typesafe.com/typesafe/releases/",
  Resolver.url("sbt snapshot plugins", url("http://repo.scala-sbt.org/scalasbt/sbt-plugin-snapshots"))(Resolver.ivyStylePatterns),
  Resolver.sonatypeRepo("snapshots"),
  "Typesafe Snapshots Repository" at "http://repo.typesafe.com/typesafe/snapshots/",
  Resolver.mavenLocal
)

addSbtPlugin("com.typesafe.sbt" % "sbt-js-engine" % "1.2.2")

scriptedLaunchOpts += ("-Dproject.version=" + version.value)

publishMavenStyle := true

publishTo := {
  if (isSnapshot.value) Some("snapshots" at "https://oss.sonatype.org/content/repositories/snapshots")
  else Some("releases" at "https://oss.sonatype.org/service/local/staging/deploy/maven2")
}

pomExtra :=
  <url>https://github.com/rgcottrell/sbt-filter</url>
  <licenses>
    <license>
      <name>Apache License, Version 2.0</name>
      <url>http://www.apache.org/licenses/LICENSE-2.0.txt</url>
      <distribution>repo</distribution>
    </license>
  </licenses>
  <scm>
    <url>git@github.com:rgcottrell/sbt-filter.git</url>
    <connection>scm:git:git@github.com:rgcottrell/sbt-filter.git</connection>
  </scm>
  <developers>
    <developer>
      <id>rgcottrell</id>
      <name>Robert Cottrell</name>
      <url>https://github.com/rgcottrell</url>
    </developer>
  </developers>
