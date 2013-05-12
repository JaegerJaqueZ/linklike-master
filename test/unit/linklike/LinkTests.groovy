package linklike



import grails.test.mixin.*
import org.junit.*

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(Link)
class LinkTests {

    void testCreateNewLink() {
  		def link = new Link(title: "Google", url: "www.google.com")

  		assert link != null
    }

    void testDefaultvoteCount(){
    	def link = new Link(title: "Google", url: "www.google.com")

    	assertEquals 0,link.voteCount
    }
}
