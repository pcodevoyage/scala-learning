
name := "Notes"

scalaVersion :="2.11.2"

val scalazVersion = "7.1.0"

libraryDependencies ++= Seq(
  "org.scalaz" %% "scalaz-core" % scalazVersion,
  "org.scalaz" %% "scalaz-effect" % scalazVersion,
  "org.scalaz" %% "scalaz-typelevel" % scalazVersion,
  "com.rabbitmq" % "amqp-client" % "2.8.1",
  "org.scalaz" %% "scalaz-scalacheck-binding" % scalazVersion % "test",
  "org.specs2" %% "specs2-core" % "2.4.14" % "test" ,
  "org.scalacheck" %% "scalacheck" % "1.12.2" % "test",
  "org.scalatest" % "scalatest_2.11" % "2.2.4" % "test"
)

scalacOptions += "-feature"

scalacOptions in Test ++= Seq("-Yrangepos")

initialCommands in console :="import scalaz._, Scalaz._"

// Read here for optional jars and dependencies:
// http://etorreborre.github.io/specs2/guide/org.specs2.guide.Runners.html#Dependencies

resolvers ++= Seq("snapshots", "releases").map(Resolver.sonatypeRepo)