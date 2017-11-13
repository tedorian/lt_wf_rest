package models

case class Action_permission(id: ActionPermissionId, name:String,action_id:ActionId,state_id:State_definitionId,assignment_proximity:String,ownership_proximity:String)

