package ru.netology

data class Post(
    // val attachments: Array<Type> = emptyArray(),
    val id: Int, // 1.идентификатор записи
    val ownerId: Int, //Идентификатор владельца стены, на которой размещена запись.
    val createdBy: Int, //Идентификатор администратора, который опубликовал запись
    val replyOwnerId: Int,// Идентификатор владельца записи, в ответ на которую была оставлена текущая.
    val fromId: String, //2. Автор записи
    val text: String, // 3. текст записи
    val date: Long, // 4.  Дата поста
    val commentsPost1: CommentsPost, // 6.комментарии
    val Likes: Int,// 7.лайки
    val isFavorite: Boolean, // 8. добавлен ли в закладки у текущего пользователя
    val canEdit: Boolean, // 9.может ли редактировать запись текущий пользователь
    val friendsOnly: Boolean,// 10. Информация была ли создана запись только для друзей
    val replyPostId: Int, //Идентификатор записи, в ответ на которую была оставлена текущая.
    val postType: String, //	Тип записи, может принимать следующие значения: post, copy, reply, postpone, suggest.
    val signerId: Int, // Идентификатор автора, если запись была опубликована от имени сообщества и подписана пользователем;
    val canPin: Boolean, //Информация о том, может ли текущий пользователь закрепить запись.
    val canDelete: Boolean = true,// Информация о том, может ли текущий пользователь удалить запись
    val isPinned: Boolean,// закреплена ли запись
    val markedAsAds: Boolean? = null, //Информация о том, содержит ли запись отметку "реклама" `
    val postponedId: Int,//Идентификатор отложенной записи. Это поле возвращается тогда, когда запись стояла на таймере.
    val donut1: Donut,
    val geo: Geo,
    val copyrRight: copyrRight,
    val likes: likes,
    val views23: Views23,
    val Reposts: Reposts,
    val attachment: Array<Attachment> = arrayOf(),



    )

data class Donut( //Информация о записи Donut:
    val isDonu: Boolean = false, // запись доступна только платным подписчикам Donut;
    val paidDuration: Double? = null, // в течении которого времени доступна запись за донат
    val canPublishFreeCopy: Boolean = true,// можно ли открыть запись для всех пользователей, а не только подписчиков  Donut;
    val editMode: String? = null,// — информация о том, какие значения VK Donut можно изменить в записи. Возможные значения
// duration — время, в течение которого запись будет доступна только платным подписчикам VK Donut.
)



data class Geo (
    //Информация о местоположении , содержит поля:
    val type: String? = null, // тип места;
    val coordinates: String? = null, // координаты места;

)
data class copyrRight ( //Источник материала, объект с полями
    val id: Int? = null,
    val link: String? = null,
    val name: String? = null,
    val type: String? = null,
)

data class likes(
//Информация о лайках к записи, объект с полями:
    val count: Int? = null,// число пользователей, которым понравилась запись;
    val userLikes: Boolean = true, // наличие отметки «Мне нравится» от текущего пользователя (1 — есть, 0 — нет);
    val canLike: Boolean = false, // информация о том, может ли текущий пользователь поставить отметку «Мне нравится» (1 — может, 0 — не может);
    val canPublish:Boolean = true,// — информация о том, может ли текущий пользователь сделать репост записи (1 — может, 0 — не может).
)
data class CommentsPost(
    val count: Int? = null, // количество комм 7.может ли комментировать пользователь
    val can_close: Boolean = true, //может ли текущий пользователь закрыть комментарии к записи*
    val can_post: Boolean = true,  // может ли комментировать пользователь
    val can_open: Boolean = true, //может ли текущий пользователь открыть комментарии к записи.
    val groupsCanPost: Boolean = true, //информация о том, могут ли сообщества комментировать запись;
)
data class Views23(
//Информация о просмотрах записи. Объект с единственным полем:
    val count12: Int? = null, //число просмотров записи.
)

data class Reposts(
    //Информация о репостах записи («Рассказать друзьям»), объект с полями:
    val count: Int? = null,// число пользователей, скопировавших запись;
    val userReposted: Boolean = true,// — наличие репоста от текущего пользователя
)

data class Comment(val id:Int, val text: String)
class PostNotFoundException : Exception()

object WallService {
    private var posts = emptyArray<Post>()
    private var postId = 1
    private var commentId = 1
    private var comments = emptyArray<Comment>()

    fun createComment(postId: Int, comment: Comment): Comment {
        for (post in posts) {
            if (post.id == postId) {
                comments += comment.copy(id = commentId++)
                return comments.last()
            }
        }
        throw PostNotFoundException()
    }

    fun add(post: Post): Post {
        posts += post.copy(id = postId++)
        return posts.last()
    }

    fun update(postInput: Post): Boolean {
        for ((index, post) in posts.withIndex()) {
            if (postInput.id == post.id) {
                posts[index] = postInput.copy()
                return true
            }
        }
        return false
    }


    fun clear() {
        posts = emptyArray()
        postId = 1
        comments = emptyArray()
        commentId = 1
    }


    fun likeById(id: Int) { //там же update требуется
        for ((index, post) in posts.withIndex()) {
            if (post.id == id) {
                posts[index] = post.copy(Likes = post.Likes + 1)
            }
        }
    }

}

abstract sealed class Attachment(val type: String)





// val type: Photo,
//val type2: Video,
//val type3: Link,
//val type4: Doc,
//val type5: Audio




class AudioAttachment(val audio: Audio) : Attachment("Audio")

class VideoAttachment(val video: Video) : Attachment("Video")

class PhotoAttachment(
    val photo: Photo
): Attachment("Photo")
class DocAttachment(val doc: Doc
): Attachment("Doc")
class LinkAttachment(val link: Link): Attachment("Link")

data class Doc (
    val id: Int? = null,//	Идентификатор документа.
    val ownerId: Int? = null, //Идентификатор пользователя, загрузившего документ.
    val title: String? = null,//Название документа.
    val size: Int?= null,// Размер документа в байтах.
    val ext: String? = null,//расширение документа.
    val url: String? = null//Адрес документа, по которому его можно загрузить.


)
data class Audio (
    val id: Int? = null, //Идентификатор аудиозаписи.
    val ownerId: Int? = null,//	Идентификатор владельца аудиозаписи.
    val artist: String? = null, //Исполнитель.
    val title: String? = null,//Название композиции.
    val duration: Int? = null,//Длительность аудиозаписи в секундах.
    val url: String? = null,//Ссылка на mp3.

)
data class Photo (
    val id: Int? = null, //Идентификатор фотографии.
    val albumId: Int? = null,//Идентификатор альбома, в котором находится фотография.
    val ownerId: Int? = null,//	Идентификатор владельца фотографии.
    val userId: Int? = null,// Идентификатор пользователя, загрузившего фото (если фотография размещена в сообществе). Для фотографий, размещенных от имени сообщества, user_id = 100.
    val text: String? = null,//Текст описания фотографии
    val date: Int? = null,//	Дата добавления в формате Unixtime.
)

data class Video (
    val id: Int? = null,//Идентификатор видеозаписи.
    val ownerId: Int? = null, //Идентификатор владельца видеозаписи.
    val title: String? = null,//Название видеозаписи.
    val description: String? = null,//Текст описания видеозаписи.
    val duration: Int? = null,//Длительность ролика в секундах.

)
data class Link (
    val url: String? = null, //URL ссылки.
    val title: String? = null, //Заголовок ссылки.
    val caption: String? = null,//Подпись ссылки (если имеется).
    val description: String? = null,//	Описание ссылки.

)
fun main() {
    val post = Post(    1, 2,5, 5, "sdada", "Vehsas", 23, CommentsPost(), 23, true, false, true, 55, "rfr ltkf" , 54, false, true, false, null,444, Donut(), Geo(), copyrRight(), likes(),Views23(), Reposts() )



    println(post)

}
