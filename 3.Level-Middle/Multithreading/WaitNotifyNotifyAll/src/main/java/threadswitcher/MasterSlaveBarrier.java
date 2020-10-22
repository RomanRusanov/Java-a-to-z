package threadswitcher;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Roman Rusanov
 * @version 0.1
 * @since 22.10.2020
 * email roman9628@gmail.com
 * The class implement barrier for two threads.
 */
public class MasterSlaveBarrier {
    /**
     * The instance with logger.
     */
    private static final Logger LOG = LoggerFactory.getLogger(MasterSlaveBarrier.class.getName());
    /**
     * The filed indicate work master thread.
     */
    private boolean masterWork;
    /**
     * The filed indicate work slave thread.
     */
    private boolean slaveWork;

    /**
     * The default constructor.
     * If masterWork - true. When start first master thread,
     * if pass false start first slave thread.
     * @param masterWork
     */
    public MasterSlaveBarrier(boolean masterWork) {
        if (!masterWork) {
            this.slaveWork = true;
        }
        this.masterWork = masterWork;
    }

    /**
     * The method mark point where master thread start.
     */
    public synchronized void tryMaster() {
        while (!this.masterWork) {
            try {
                notify();
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            this.masterWork = true;
        }
    }
    /**
     * The method mark point where slave thread start.
     */
    public synchronized void trySlave() {
        while (!this.slaveWork) {
            try {
                notify();
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            this.slaveWork = true;
        }
    }
    /**
     * The method call when master thread reach wait point.
     */
    public synchronized void doneMaster() {
        this.masterWork = false;
    }
    /**
     * The method call when slave thread reach wait point.
     */
    public synchronized void doneSlave() {
        this.slaveWork = false;
    }
}