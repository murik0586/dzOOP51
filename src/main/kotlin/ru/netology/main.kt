package ru.netology

data class Post(
    val id: Int, // 1.идентификатор записи
    val fromId: String, //2. Автор записи //используйте camelCase
    val text: String, // 3. текст записи
    val date: Long, // 4.  Дата поста
    val Views: Int,  /* 5. Информация о просмотрах записи. Объект с единственным полем*/
    val commentsPost1: CommentsPost, // 6.комментарии
    val Likes: Int,// 7.лайки
    val isFavorite: Boolean, // 8. добавлен ли в закладки у текущего пользователя
    val canEdit: Boolean, // 9.может ли редактировать запись текущий пользователь
    val friendsOnly: Boolean// 10. Информация была ли создана запись только для друзей.

)


data class CommentsPost(
    val count: Int = 0, // 5.количество комм 7.может ли комментировать пользователь
    val can_close: Boolean = true, //8.может ли текущий пользователь закрыть комментарии к записи*
    val can_post: Boolean = true,  // 7.может ли комментировать пользователь
    val can_open: Boolean = true, //9.может ли текущий пользователь открыть комментарии к записи.

)

object  WallService {
    private var posts = emptyArray<Post>()
    private var postId = 1

    fun add (post: Post): Post {
        posts += post.copy(id = postId++)
        return posts.last()
    }

    fun update(postInput: Post): Boolean {
        for ((index, post) in posts.withIndex()) {
            if (postInput.id == post.id) {
                posts[index] = postInput.copy()
                return true
            } // 3 теста с аннотацией @Test и функция с аннотацией @Before которая будет очищать синглтон перед каждым тестом. Хорошо, чтобы не тратить ваше время, я приступлю, Если что я в текстовом виде к вам обращусь ок
        }
        return false
    }

    fun clear() {
        posts = emptyArray()
        postId = 1
    }

    fun likeById(id: Int) { //там же update требуется
        for ((index,post) in posts.withIndex()) {
            if (post.id == id) {
                posts[index] = post.copy(Likes = post.Likes + 1)
            }
        }
    }


}

//fun add(post: Post): Post {
    //TODO()
//}
fun main() {
    val post = Post(10, "Murat", "post", 23, 10, CommentsPost(), Likes = 0, true, true, friendsOnly = false)
    println(post)
    val (id, from, text) = post
    val Liked = post.copy(Likes = post.Likes + 1)

}