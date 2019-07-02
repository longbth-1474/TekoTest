package longhoang.test.teko.utils.rx;

import io.reactivex.Scheduler;

/**
 * Created by Cong Nguyen on 2/18/19.
 */
public interface SchedulerProvider {
    Scheduler computation();
    Scheduler io();
    Scheduler ui();
}
