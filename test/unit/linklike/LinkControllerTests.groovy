package linklike



import grails.test.mixin.*
import org.junit.*

/**
 * See the API for {@link grails.test.mixin.web.ControllerUnitTestMixin} for usage instructions
 */
@TestFor(LinkController)
@Mock([Link])
class LinkControllerTests {

    void testCreateNewLink() {
    	params.title = "Google"
    	params.url = "www.google.com"
    	controller.create()
    	
    	assertEquals 1,Link.count()
    }

    void testVoteUp1(){
    	def link = new Link(title: "Google", url: "www.google.com")
        link.save()

        params.url = "www.google.com"
    	controller.vote()

    	assertEquals 1, Link.get(1).voteCount
    }

    void testVoteUp2(){
    	def link = new Link(title: "Google", url: "www.google.com")
        link.save()

		link = new Link(title: "Soccersuck", url: "www.soccersuck.com")
        link.save()

        params.url = "www.soccersuck.com"
    	controller.vote()

    	assertEquals 0, Link.get(1).voteCount
    	assertEquals 1, Link.get(2).voteCount
    }
}
