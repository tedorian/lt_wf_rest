import akka.http.scaladsl.server.Directives._
import api.{ModulesApi, PostsApi, ApiErrorHandler, UsersApi}

trait Routes extends ApiErrorHandler with UsersApi with PostsApi with ModulesApi{
  val routes =
    pathPrefix("v1") {
      usersApi ~
      postsApi ~
      modulesApi
    } ~ path("")(getFromResource("public/index.html"))
}
