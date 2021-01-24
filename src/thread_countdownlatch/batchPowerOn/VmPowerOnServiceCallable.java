package thread_countdownlatch.batchPowerOn;

import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;

public class VmPowerOnServiceCallable implements Callable<VmOperResult> {

    private String vmId;
    private CountDownLatch latch;

    @Override
    public VmOperResult call() {
        VmOperResult result = new VmOperResult();
        result.setVmId(vmId);
        // 模拟开机
        try {
            // 01 02成功，sleep2s
            if (vmId.contains("01") || vmId.contains("02")) {
                Thread.sleep(1200);
                buildResult(result, true, null, latch);
                return result;
            }
            // 03 04成功，sleep3.2s
            if (vmId.contains("03")) {
                Thread.sleep(2100);
                buildResult(result, true, null, latch);
                return result;
            }
            if (vmId.contains("04")) {
                Thread.sleep(5200);
                buildResult(result, true, null, latch);
                return result;
            }
            // 05 06失败，sleep1.5s
            if (vmId.contains("05") || vmId.contains("06")) {
                Thread.sleep(1500);
                buildResult(result, false, "Id specify error whose id is " + vmId, latch);
                return result;
            }
            // 07 08失败，sleep2.2s
            if (vmId.contains("07") || vmId.contains("08")) {
                Thread.sleep(2200);
                throw new NullPointerException();
            }
        } catch (Exception e) {
            buildResult(result, false, "Null exception whose id is " + vmId, latch);
            return result;
        }
        return null;
    }

    private void buildResult(VmOperResult result, boolean flag, String errmsg, CountDownLatch latch) {
        result.setFlag(flag);
        result.setErrmsg(errmsg);
        if (flag) {
            System.out.println(vmId + " success.");
        } else {
            System.out.println(vmId + " failed. " + errmsg);
        }
        latch.countDown();
    }

    public VmPowerOnServiceCallable(String vmId, CountDownLatch latch) {
        this.vmId = vmId;
        this.latch = latch;
    }
}
