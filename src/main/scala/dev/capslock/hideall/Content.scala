import scala.scalajs.js
import scala.scalajs.js.annotation._
import org.scalajs.dom
import org.scalajs.dom.MutationObserver
import org.scalajs.dom.MutationObserverInit

@JSExportTopLevel("Content", "content")
object Content {
  // trivial example: hue rotate verified badge on x.com
  if (dom.document.location.hostname == "x.com") {
    val ob = MutationObserver((list, observer) => {
      val badges = dom.document.querySelectorAll("""[aria-label="認証済みアカウント"]""")
      badges.toSeq.foreach { e =>
        e.setAttribute("style", "filter: hue-rotate(90deg)")
        println("setting attr")
      }
    })
    ob.observe(
      dom.document.body,
      MutationObserverInit(childList = true, subtree = true)
    )
  }
}
