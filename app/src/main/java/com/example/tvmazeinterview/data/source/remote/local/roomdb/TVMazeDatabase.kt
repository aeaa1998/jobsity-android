package com.example.tvmazeinterview.data.source.remote.local.roomdb

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverter
import androidx.room.TypeConverters
import com.example.tvmazeinterview.data.source.remote.local.roomdb.converter.Converters
import com.example.tvmazeinterview.data.source.remote.local.roomdb.dao.FavoriteTVMazeShowDao
import com.example.tvmazeinterview.data.source.remote.local.roomdb.dao.TVMazeShowEntityDao
import com.example.tvmazeinterview.data.source.remote.local.roomdb.entity.FavoriteTVMazeShowEntity
import com.example.tvmazeinterview.data.source.remote.local.roomdb.entity.TVMazeShowEntity
import com.example.tvmazeinterview.data.source.remote.local.roomdb.entity.FavoriteWithTVShow

@Database(
    entities = [TVMazeShowEntity::class, FavoriteTVMazeShowEntity::class],
    version = 1,
//    exportSchema = false
)
@TypeConverters(Converters::class)
abstract class TVMazeDatabase : RoomDatabase() {
    abstract fun getFavoriteTVMazeShowDao(): FavoriteTVMazeShowDao

    abstract fun getTVMazeShowEntityDao(): TVMazeShowEntityDao
}