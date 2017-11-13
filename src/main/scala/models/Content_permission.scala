package models

case class Content_permission(id: ContentPermissionId, content_lentl_type:ContentLentlTypeId,uri:String,name:String,action_id:ActionId,state_id:State_definitionId,assignment_proximity:String,ownership_proximity:String,permission_code:String)
