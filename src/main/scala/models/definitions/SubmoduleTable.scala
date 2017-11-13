package models.definitions

import models.{Submodule, SubmoduleId,ModuleId}
import slick.driver.PostgresDriver.api._

class SubmoduleTable(tag: Tag) extends Table[Submodule](tag, "submodule"){
  def id = column[SubmoduleId]("id", O.PrimaryKey, O.AutoInc)
  def uri = column[String]("uri")
  def module_id = column[ModuleId]("module_id")
  def name = column[String]("name")
  def * = (id, module_id, uri, name) <> ((Submodule.apply _).tupled, Submodule.unapply)
}

