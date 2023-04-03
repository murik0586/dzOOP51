package ru.netology

import org.junit.Test

import org.junit.Assert.*
import org.junit.Before


class PostTest {

    @Test
    fun add1() {
        val result = WallService.add(Post(0, 23, 24, 26, "Murat Musaev", "Первый пост", 23,CommentsPost(), 23, false, true, false, 34, "post", 23, true, true,false, true, 23, donut(), geo(), copyrRight(), likes(),Views23(), Reposts()))
        assertEquals(1, result.id)
    }

    @Test
    fun update3() {
        val service2 = WallService
        service2.add(Post(0,2,5, 5, "sdada", "Vehsas", 23, CommentsPost(), 23, true, false, true, 55, "rfr ltkf" , 54, false, true, false, null,444, donut(), geo(), copyrRight(), likes(),Views23(), Reposts() ))
        service2.add(Post(1,2,5, 5, "sdada", "Vehsas", 23, CommentsPost(), 23, true, false, true, 55, "rfr ltkf" , 54, false, true, false, null,444, donut(), geo(), copyrRight(), likes(),Views23(), Reposts() ))
        service2.add(Post(3,2,5, 5, "sdada", "Vehsas", 23, CommentsPost(), 23, true, false, true, 55, "rfr ltkf" , 54, false, true, false, null,444, donut(), geo(), copyrRight(), likes(),Views23(), Reposts() ))
        var update = Post(3,2,5, 5, "sdada", "Vehsas", 23, CommentsPost(), 23, true, false, true, 55, "rfr ltkf" , 54, false, true, false, null,444, donut(), geo(), copyrRight(), likes(),Views23(), Reposts() )

        val result = service2.update(update)

        assertTrue(result)
    }


    @Test
    fun update2() {
        val service2 = WallService
        service2.add(Post(0,2,5, 5, "sdada", "Vehsas", 23, CommentsPost(), 23, true, false, true, 55, "rfr ltkf" , 54, false, true, false, null,444, donut(), geo(), copyrRight(), likes(),Views23(), Reposts() ))
        service2.add(Post(1,2,5, 5, "sdada", "Vehsas", 23, CommentsPost(), 23, true, false, true, 55, "rfr ltkf" , 54, false, true, false, null,444, donut(), geo(), copyrRight(), likes(),Views23(), Reposts() ))
        service2.add(Post(3,2,5, 5, "sdada", "Vehsas", 23, CommentsPost(), 23, true, false, true, 55, "rfr ltkf" , 54, false, true, false, null,444, donut(), geo(), copyrRight(), likes(),Views23(), Reposts() ))
        var update = Post(4,2,5, 5, "sdada", "Vehsas", 23, CommentsPost(), 23, true, false, true, 55, "rfr ltkf" , 54, false, true, false, null,444, donut(), geo(), copyrRight(), likes(),Views23(), Reposts() )
        val result = service2.update(update)

        assertFalse(result)
    }
    @Before
    fun clearBeforeTest() {
        WallService.clear()
    }

}



