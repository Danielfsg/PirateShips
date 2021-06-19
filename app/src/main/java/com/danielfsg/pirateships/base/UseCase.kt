package com.danielfsg.pirateships.base

import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.disposables.Disposable

abstract class UseCase<out T> {
    protected var lastDisposable: Disposable? = null
    protected val compositeDisposable = CompositeDisposable()

    abstract fun build(): T

    fun disposeLast() {
        lastDisposable?.let {
            if (!it.isDisposed) {
                it.dispose()
            }
        }
    }

    fun dispose() {
        compositeDisposable.dispose()
    }
}