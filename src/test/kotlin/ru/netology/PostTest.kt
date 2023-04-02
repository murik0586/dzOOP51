package ru.netology

import org.junit.Test

import org.junit.Assert.*
import org.junit.Before


class PostTest {

    @Test
    fun add1() {
        val result = WallService.add(Post(0, "vfkds", "vdds", 12, 10, CommentsPost(), 12, true, true, true))
        assertEquals(1, result.id)
    }

    @Test
    fun update3() {
        val service1 = WallService
        service1.add(Post(0, "vf212kds", "vd34fds", 123, 110, CommentsPost(), 12, true, true, true))
        service1.add(Post(1, "vf212kds", "vd34fds", 123, 110, CommentsPost(), 12, true, true, true))
        service1.add(Post(3, "vfkds", "vdds", 12, 10, CommentsPost(), 12, false, true, true))
        var update = Post(3, "vfkds22222", "vdds", 12, 10, CommentsPost(), 1222, true, true, false)

        val result = service1.update(update)

        assertTrue(result)
    }


    @Test
    fun update2() {
        val service1 = WallService
        service1.add(Post(0, "vf212kds", "vd34fds", 123, 110, CommentsPost(), 12, true, true, true))
        service1.add(Post(1, "vf212kds", "vd34fds", 123, 110, CommentsPost(), 12, true, true, true))
        service1.add(Post(3, "vfkds", "vdds", 12, 10, CommentsPost(), 12, false, true, true))
        var update = Post(4, "vfkds22222", "vdds", 12, 10, CommentsPost(), 1222, true, true, false)

        val result = service1.update(update)

        assertFalse(result)
    }
    @Before
    fun clearBeforeTest() {
        WallService.clear()
    }

}



