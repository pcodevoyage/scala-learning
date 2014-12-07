name := "Notes"


libraryDependencies ++= Seq(
  "org.specs2" %% "specs2-core" % "2.4.14" % "test"
)

scalacOptions in Test ++= Seq("-Yrangepos")

// Read here for optional jars and dependencies:
// http://etorreborre.github.io/specs2/guide/org.specs2.guide.Runners.html#Dependencies

resolvers ++= Seq("snapshots", "releases").map(Resolver.sonatypeRepo)