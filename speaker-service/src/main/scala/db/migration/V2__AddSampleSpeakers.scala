package db.migration

import com.twitter.util.{Await, Future}

import scalatalk.common.db.{SlickMigration, UnmanagedDatabase}
import scalatalk.speaker.dao.SpeakerDao
import scalatalk.speaker.entity.Speaker

class V2__AddSampleSpeakers extends SlickMigration {

	override def migrate(database: UnmanagedDatabase): Unit = {
		val speakerDao = new SpeakerDao(database)
		val f1 = speakerDao.create(Speaker("speaker1", "Blue Elephant"))
		val f2 = speakerDao.create(Speaker("speaker2", "Red Dog"))
		val f3 = speakerDao.create(Speaker("speaker3", "Yellow Fish"))
		Await.result(Future.join(f1, f2, f3))
	}

}
