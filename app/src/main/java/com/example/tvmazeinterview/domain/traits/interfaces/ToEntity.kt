package com.example.tvmazeinterview.domain.traits.interfaces


/**
 * Defines a behaviour that can map to another entity
 */
interface ToEntity<Entity> {
    fun toEntity() : Entity
}