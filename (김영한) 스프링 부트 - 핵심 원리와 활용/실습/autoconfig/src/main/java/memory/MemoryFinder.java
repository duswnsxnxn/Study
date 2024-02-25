package memory;

import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MemoryFinder {

    public Memory getMemory() {
        long maxMemory = Runtime.getRuntime().maxMemory();
        long total = Runtime.getRuntime().totalMemory();
        long usedMemory = total - Runtime.getRuntime().freeMemory();
        return new Memory(usedMemory, maxMemory);
    }

    @PostConstruct
    public void init() {
        log.info("MemoryFinder bean created");
    }
}
