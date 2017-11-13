package models.definitions

import models.{Lentl_typeId, SubmoduleId, Lentl_type}
import slick.driver.PostgresDriver.api._

class Lentl_typeTable(tag: Tag) extends Table[Lentl_type](tag, "lentl_type"){
  def id = column[Lentl_typeId]("id", O.PrimaryKey, O.AutoInc)
  def submodule_id = column[SubmoduleId]("submodule_id")
  def uri = column[String]("uri")
  def name = column[String]("name")
  def * = (id, submodule_id, uri, name) <> ((Lentl_type.apply _).tupled, Lentl_type.unapply)
}

