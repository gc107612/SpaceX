package com.example.spacex.rxbus;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subjects.PublishSubject;

@SuppressWarnings("unused")
public class RxBus {

    private final CompositeDisposable disposable = new CompositeDisposable();
    private PublishSubject<Object> bus = PublishSubject.create();

    private RxBus() {
    }

    public synchronized static RxBus getInstance() {
        return RxBusInstanceHolder.INSTANCE;
    }

    public Observable<Object> getFragmentEventObservable() {
        return bus;
    }

    public Disposable subscribeToBus(Consumer consumer) {
        return bus.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(consumer);
    }

    public void postAction(Object actionId) {
        bus.onNext(actionId);
    }

    public void register(Disposable disposableInstance) {
        disposable.add(disposableInstance);
    }

    public void unregister(Disposable disposableInstance) {
        disposable.remove(disposableInstance);
    }

    private static class RxBusInstanceHolder {
        private static final RxBus INSTANCE = new RxBus();
    }
}