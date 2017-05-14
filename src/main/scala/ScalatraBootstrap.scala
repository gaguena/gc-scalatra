import com.gaguena.app._
import org.scalatra._
import javax.servlet.ServletContext
import com.gaguena.app.rest.PostingRest

class ScalatraBootstrap extends LifeCycle {
  override def init(context: ServletContext) {
    context.mount(new PostingRest, "/post")
  }
}
