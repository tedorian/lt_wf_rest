package dao

import models.definitions._
import slick.dbio.{Effect, NoStream}
import slick.lifted.TableQuery
import slick.profile.{FixedSqlAction, FixedSqlStreamingAction, SqlAction}
import utils.DatabaseConfig

import scala.concurrent.Future

trait BaseDao extends DatabaseConfig {
  val modulesTable = TableQuery[ModulesTable]
  val usersTable = TableQuery[UsersTable]
  val postsTable = TableQuery[PostsTable]
  val commentsTable = TableQuery[CommentsTable]
  val submodulesTable = TableQuery[SubmoduleTable]
  val lentil_typeTable = TableQuery[Lentl_typeTable]
  val roleTable = TableQuery[RoleTable]
  val workflowTable = TableQuery[WorkflowTable]
  val state_definitionTable = TableQuery[State_definitionTable]
  val actionTable = TableQuery[ActionTable]
  val action_stateTable = TableQuery[Action_stateTable]
  val action_permissionTable = TableQuery[Action_permissionTable]
  val content_typeTable = TableQuery[Content_typeTable]
  val content_lentl_typeTable = TableQuery[Content_lentl_typeTable]

  protected implicit def executeFromDb[A](action: SqlAction[A, NoStream, _ <: slick.dbio.Effect]): Future[A] = {
    db.run(action)
  }
  protected implicit def executeReadStreamFromDb[A](action: FixedSqlStreamingAction[Seq[A], A, _ <: slick.dbio.Effect]): Future[Seq[A]] = {
    db.run(action)
  }
}
