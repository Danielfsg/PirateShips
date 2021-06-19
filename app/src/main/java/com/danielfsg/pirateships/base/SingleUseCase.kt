package com.danielfsg.pirateships.base

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.schedulers.Schedulers

abstract class SingleUseCase<T> : UseCase<Single<T>>() {

    fun execute(
        onSuccess: (t: T) -> Unit,
        onError: (t: Throwable) -> Unit,
        onComplete: () -> Unit = {}
    ) {
        disposeLast()
        lastDisposable = build()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doAfterTerminate(onComplete)
            .subscribe(onSuccess, onError)

        lastDisposable?.let {
            compositeDisposable.add(it)
        }
    }

}