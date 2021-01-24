package thread_countdownlatch.batchPowerOn;

public class VmOperResult {

    private String vmId;
    private String operation = "POWERON";
    private boolean flag;
    private String errmsg;

    public String getVmId() {
        return vmId;
    }

    public void setVmId(String vmId) {
        this.vmId = vmId;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public String getErrmsg() {
        return errmsg;
    }

    public void setErrmsg(String errmsg) {
        this.errmsg = errmsg;
    }

    @Override
    public String toString() {
        return "VmOperResult{" +
                "vmId='" + vmId + '\'' +
                ", operation='" + operation + '\'' +
                ", flag=" + flag +
                ", errmsg='" + errmsg + '\'' +
                '}';
    }
}
