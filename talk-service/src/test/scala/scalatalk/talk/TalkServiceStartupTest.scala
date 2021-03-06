package scalatalk.talk

import com.google.inject.Stage
import com.twitter.finatra.http.EmbeddedHttpServer

import scalatest.common.FinatraFeatureTest

class TalkServiceStartupTest extends FinatraFeatureTest {

	override val server = new EmbeddedHttpServer(
		stage = Stage.PRODUCTION,
		twitterServer = new TalkServer
	)

	test("Server should start") {
		server.assertHealthy()
	}

}
