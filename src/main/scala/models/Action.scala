package models

case class Action(id: ActionId, workflow_id:WorkflowId, uri: String, name: String,increment_cycle_id:Boolean,cycle_bound:Boolean)
