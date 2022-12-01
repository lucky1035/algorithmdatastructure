package sdk;

import com.google.common.collect.Lists;

import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.concurrent.*;
import java.util.stream.Collectors;

public class CompletableFutureTest {


    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(5);
        List<Integer> requests = Lists.newArrayList(1,2,3,4,5,6,7,8,9);
        List<Integer> results = Lists.newArrayList();
        CountDownLatch countDownLatch  = new CountDownLatch(9);

//        List<CompletableFuture<Integer>> futureList = requests
//                .stream()
//                .map(request->
//                        CompletableFuture.supplyAsync( () -> {
//                            System.out.println("执行子线程中。。。。。。。。");
//                            return request;
//                        },executor))
//                .collect(Collectors.toList());

        for(Integer request :requests){
            executor.execute(()->{
                countDownLatch.countDown();
                System.out.println("第 ："+request+"个线程开完成工作");
                results.add(1);
            });
        }

        try {
            countDownLatch.await(2,TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

//        IntSummaryStatistics agesum = futureList.stream().mapToInt((e)-> {
//            try {
//                return (Integer) e.get();
//            } catch (InterruptedException ex) {
//                throw new RuntimeException(ex);
//            } catch (ExecutionException ex) {
//                throw new RuntimeException(ex);
//            }
//        }).summaryStatistics() ;
//        System.out.println(String.valueOf(agesum.getSum()));
        System.out.println(results.stream().mapToInt(e->e).sum());



    }


}
