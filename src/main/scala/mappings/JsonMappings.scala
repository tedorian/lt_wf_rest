package mappings

import models._
import spray.json.DefaultJsonProtocol

trait JsonMappings extends DefaultJsonProtocol {
  implicit val userFormat = jsonFormat5(User)
  implicit val postFormat = jsonFormat4(Post)
  implicit val commentFormat = jsonFormat4(Comment)
  implicit val moduleFormat = jsonFormat3(Module)
  implicit val action_permissionFormat = jsonFormat6(Action_permission)
  implicit val action_stateFormat = jsonFormat3(Action_state)
  implicit val actionFormat = jsonFormat6(Action)
  implicit val content_permissionFormat = jsonFormat9(Content_permission)
  implicit val content_typeFormat = jsonFormat3(Content_type)
  implicit val fieldFormat = jsonFormat3(Field)
  implicit val roleFormat = jsonFormat4(Role)
  implicit val lentl_typeFormat = jsonFormat4(Lentl_type)
  implicit val state_definitionFormat = jsonFormat4(State_definition)
  implicit val content_lentl_typeFormat = jsonFormat3(Content_lentl_type)
}