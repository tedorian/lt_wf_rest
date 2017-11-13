package dao

import models.{Post, PostId, UserId}
import slick.driver.PostgresDriver.api._

import scala.concurrent.Future

object PostsDao extends BaseDao{
  def findUserPosts2(userId: UserId): Future[Seq[Post]] = {
    (for{
      user <- usersTable.filter(_.id === userId)
      posts <- postsTable.filter(_.userId === user.id)
    } yield posts).result
  }
  def findUserPosts1(userId: UserId): Future[Seq[Post]] = {
     postsTable.result
  }
  def findByUserIdAndId(userId: UserId, postId: PostId): Future[Post] = {
    (for{
      user <- usersTable.filter(_.id === userId)
      post <- postsTable.filter(_.id === postId)
    } yield post).result.head
  }
  def create(post: Post): Future[PostId] = postsTable returning postsTable.map(_.id) += post
  def update(newPost: Post, postId: PostId): Future[Int] = postsTable.filter(_.id === postId)
    .map(post => (post.title, post.content))
    .update((newPost.title, newPost.content))

  def delete(postId: PostId): Future[Int] = postsTable.filter(_.id === postId).delete


  def findUserPosts(userId: UserId): Future[(String,String)] = {
    ("wer","sdfsdfsdfsdfsdf")
    .result
  }
}

//(people join addresses on (_.addressId === _.id))
//.map{ case (p, a) => (p.name, a.city) }.result