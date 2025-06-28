
import io.s4.dispatcher.partitioner.CompoundKeyInfo;
import io.s4.dispatcher.partitioner.Hasher;
import io.s4.processor.PrototypeWrapper;
import io.s4.util.MethodInvoker;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
public class PrototypeRequest extends Request {
    private final List<String> query;
    public PrototypeRequest(List<String> query, RInfo info) {
        this.query = query;
        this.rinfo = info;
    }
    public PrototypeRequest(List<String> query) {
        this.query = query;
        this.rinfo = null;
    }
    public PrototypeRequest() {
        this.query = Collections.<String> emptyList();
        this.rinfo = null;
    }
    public String toString() {
        return "PROTOTYPE: query=[" + query + "] info=[" + rinfo + "]";
    }
    public List<String> getQuery() {
        return query;
    }
    public Response evaluate(PrototypeWrapper pw) {
        HashMap<String, Object> results = new HashMap<String, Object>();
        HashMap<String, String> exceptions = new HashMap<String, String>();
        for (String q : query) {
            if (q.startsWith("$")) {
                try {
                    Object res = MethodInvoker.invokeGetter(pw, q.substring(1));
                    results.put(q, res);
                } catch (Exception e) {
                    exceptions.put(q, e.toString());
                }
            } else if (q.equalsIgnoreCase("count")) {
                results.put(q, pw.getPECount());
            } else {
                exceptions.put(q, "Query Parse Error");
            }
        }
        return new Response(results, exceptions, this);
    }
    public List<CompoundKeyInfo> partition(Hasher h, String delim, int partCount) {
        List<CompoundKeyInfo> partitionInfoList = new ArrayList<CompoundKeyInfo>();
        for (int i = 0; i < partCount; ++i) {
            CompoundKeyInfo partitionInfo = new CompoundKeyInfo();
            partitionInfo.setPartitionId(i);
            partitionInfoList.add(partitionInfo);
        }
        return partitionInfoList;
    }
}
