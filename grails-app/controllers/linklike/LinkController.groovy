package linklike

class LinkController {

    def index() { 
        def links = Link.findAll()
        [ links: links ]
    }

    def create() {
        def link = new Link(title: params.title, url: params.url)
        link.save()
        redirect(action: "index")
    }

    def vote() {
        def links = Link.findAll()
        def name = params.url
        for(link in links)
            if(link.url == name)
                link.voteCount++
        redirect(action: "index")
    }
}
