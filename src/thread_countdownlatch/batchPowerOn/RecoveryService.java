package thread_countdownlatch.batchPowerOn;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * 按优先级，批次处理虚拟机开机任务。
 * 先开机priority=1的N个虚拟机，再开机priority=2的M个虚拟机，再开机priority=3的H个虚拟机......
 * 主线程latch.await()等待，各个子线程latch.countDown
 */
public class RecoveryService {

    public static void main(String[] args) throws InterruptedException {

        // 构造3个优先级的vm数据
        HashMap<Integer, List<String>> vmMaps = initVmDatas();

        Set<Integer> priorities = vmMaps.keySet();
        List<Future> allVmOperResList = new ArrayList<>();

        ExecutorService executor = Executors.newCachedThreadPool();

        for (Integer priority : priorities) {
            System.out.println("开始优先级" + priority + "的vm开机:");

            // 处理本优先级的vm的开机任务
            List<String> vmList = vmMaps.get(priority);
            CountDownLatch latch = new CountDownLatch(vmList.size());
            for (String vmId : vmList) {
                VmPowerOnServiceCallable task = new VmPowerOnServiceCallable(vmId, latch);
                Future<VmOperResult> result = executor.submit(task);
                allVmOperResList.add(result);
            }

            // 等待本优先级的vm都处理完
            latch.await();

            System.out.println("结束优先级" + priority + "的vm处理，完毕。");
        }

        executor.shutdown();

        System.out.println("===========================");
        for (Future res : allVmOperResList) {
            try {
                System.out.println(res.get().toString());
            } catch (Exception e) {
                System.out.println("ERROR!" + e.getMessage());
            }
        }
    }

    private static HashMap initVmDatas() {
        HashMap<Integer, List<String>> map = new HashMap();
        List<String> vms1 = new ArrayList<>();
        vms1.add("vm1-01");
        vms1.add("vm1-02");
        vms1.add("vm1-03");
        vms1.add("vm1-04");
        vms1.add("vm1-05");
        vms1.add("vm1-06");
        vms1.add("vm1-07");
        vms1.add("vm1-08");
        map.put(1, vms1);
        List<String> vms2 = new ArrayList<>();
        vms2.add("vm2-01");
        vms2.add("vm2-02");
        vms2.add("vm2-03");
        vms2.add("vm2-04");
        vms2.add("vm2-05");
        vms2.add("vm2-06");
        vms2.add("vm2-07");
        map.put(2, vms2);
        List<String> vms3 = new ArrayList<>();
        vms3.add("vm3-01");
        vms3.add("vm3-03");
        vms3.add("vm3-04");
        vms3.add("vm3-05");
        vms3.add("vm3-07");
        map.put(3, vms3);
        return map;
    }
}
