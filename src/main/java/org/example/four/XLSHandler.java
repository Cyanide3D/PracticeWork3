package org.example.four;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;

public class XLSHandler implements Observer<File> {
    @Override
    public void onSubscribe(@NonNull Disposable d) {

    }

    @Override
    public void onNext(File o) { //Просто сверяем тип, пишем о том, что обработали и ждём
        if (o.getType().equals(FileType.XLS)) {
            System.out.println("Handle XLS file...");
            try {
                Thread.sleep(o.getSize()*7);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @Override
    public void onError(@NonNull Throwable e) {

    }

    @Override
    public void onComplete() {

    }
}
