package com.example.demomultithread.Java8;

import com.alibaba.fastjson.JSON;
import org.assertj.core.util.Lists;
import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.*;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import org.junit.jupiter.api.Test;



@SpringBootTest
public class Jdk8StreamTest {

    private List<Product> productList;


    public List<Product> getProductList() {
        List productList = Lists.newArrayList();
        Product product1 = new Product(1L, "苹果", new BigDecimal(3.5), 500, 1, 1);
        Product product2 = new Product(2L, "梨子", new BigDecimal(2.5), 300, 1, 2);
        Product product3 = new Product(3L, "猪肉", new BigDecimal(25), 700, 1, 1);
        Product product4 = new Product(4L, "格林童话", new BigDecimal(18), 200, 2, 2);
        Product product5 = new Product(5L, "小米10手机", new BigDecimal(3999), 800, 2, 1);
        Product product6 = new Product(6L, "崇明大米50kg", new BigDecimal(112), 50, 3, 1);

        productList.add(product1);
        productList.add(product2);
        productList.add(product3);
        productList.add(product4);
        productList.add(product5);
        productList.add(product6);
        return productList;
    }

    @BeforeEach
    public void initParam() {
        productList = getProductList();
    }

    @AfterEach
    public void test() {
        productList.forEach(i -> {
            System.out.println(i.name);
        });
    }


    /**
     * filter()
     */
    @Test
    public void testFilter() {
        productList = productList.stream().filter(i -> (i.getStock() > 100 && i.status == 2)).collect(Collectors.toList());
    }

    /**
     * sorted()
     */
    @Test
    public void testSort() {
        productList = productList.stream().sorted(Comparator.comparing(Product::getPrice)).collect(Collectors.toList());
    }

    /**
     * distinct()
     */
    @Test
    public void testDistinct() {
        Product product = new Product(1L, "苹果", new BigDecimal(3.5), 500, 1, 1);
        productList.add(product);
        productList = productList.stream().distinct().collect(Collectors.toList());
    }


    @Test
    public void testLimit() {
        productList = productList.stream().limit(3).collect(Collectors.toList());
    }

    /**
     * 返回一个扔掉了前n个元素的流。如果流中元素不足n个，则返回一 个空流
     */
    @Test
    public void testSkip() {
        productList = productList.stream().skip(2).collect(Collectors.toList());
    }

    /**
     * 接受一个函数作为参数。这个函数会被应用到每个元素上，并将其映 射成一个新的元素
     */
    @Test
    public void testMap() {
        List<Long> ids = productList.stream().map(Product::getId).collect(Collectors.toList());
        System.out.println(JSON.toJSONString(ids));
    }

    /**
     * flatMap 将生成的单个流都被合并起来，即扁平化为一个流
     */
    @Test
    public void testFlatMap() {
        List<List<Product>> products = new ArrayList<>();

        Product product1 = new Product(1L, "苹果", new BigDecimal(3.5), 500, 1, 1);
        Product product2 = new Product(2L, "梨子", new BigDecimal(2.5), 300, 1, 2);
        Product product3 = new Product(3L, "猪肉", new BigDecimal(25), 700, 1, 1);
        Product product4 = new Product(4L, "格利童话", new BigDecimal(18), 200, 2, 2);
        Product product5 = new Product(5L, "小米10手机", new BigDecimal(3999), 800, 2, 1);
        Product product6 = new Product(6L, "崇明大米50kg", new BigDecimal(112), 50, 3, 1);
        List productList1 = Lists.newArrayList();
        productList1.add(product1);
        productList1.add(product2);
        productList1.add(product3);
        List productList2 = Lists.newArrayList();
        productList2.add(product4);
        productList2.add(product5);
        productList2.add(product6);

        products.add(productList1);
        products.add(productList2);

        List<String> nameList = products.stream().flatMap(s -> s.stream()).map(Product::getName).collect(Collectors.toList());
        System.out.println(JSON.toJSONString(nameList));
    }


    @Test
    public void testMatch() {
        // 检查谓词是否至少匹配一个元素
        boolean result = productList.stream().anyMatch(i -> i.name.equals("苹果"));
        System.out.println(result);
        // 检查谓词是否匹配所有元素
        result = productList.stream().allMatch(i -> i.name.equals("苹果"));
        System.out.println(result);

        Optional<Product> p = productList.stream().findAny();
        System.out.println(p.get().name);

        p = productList.stream().findFirst();
        System.out.println(p.get().name);
    }

    /**
     * 归约
     */
    @Test
    public void testReduce() {
        BigDecimal priceTotal = productList.stream().map(i -> i.getPrice()).reduce(BigDecimal.ZERO, BigDecimal::add);
        System.out.println(priceTotal);
        Integer stockTotal = productList.stream().map(i -> i.getStock()).reduce(0, Integer::sum);
        System.out.println(stockTotal);

        Optional<Integer> stockMin = productList.stream().map(i -> i.getStock()).reduce(Integer::min);
        System.out.println(stockMin.orElse(0));
        Optional<BigDecimal> priceMin = productList.stream().map(i -> i.getPrice()).reduce(BigDecimal::min);
        System.out.println(priceMin.orElse(BigDecimal.ZERO));

        Optional<Product> priceMax = productList.stream().max(Comparator.comparing(Product::getPrice));
        System.out.println(priceMax.get().toString());
    }

    /**
     * 原始类型流特化 分别将流中的元素特化为int、long和double，避免了暗含的装箱成本
     */
    @Test
    public void testOriginal() {
        Integer stockSum = productList.stream().mapToInt(Product::getStock).sum();
        System.out.println(stockSum);

        // 数值范围 2-100所有的偶数
        IntStream numbers = IntStream.rangeClosed(1, 100).filter(n -> n % 2 == 0);
        for (PrimitiveIterator.OfInt it = numbers.iterator(); it.hasNext(); ) {
            Integer ofInt = it.next();
            System.out.println(ofInt);
        }
    }


    /**
     * Collectors 静态方法 -- 收集器
     */
    @Test
    public void testCollectors() {
        System.out.println("counting");
        Long count = productList.stream().collect(Collectors.counting());
        System.out.println(count);
        Long count2 = productList.stream().count();
        System.out.println(count2);

        System.out.println("maxBy, minBy");
        Optional<BigDecimal> price = productList.stream().collect(Collectors.maxBy(Comparator.comparing(Product::getPrice))).map(Product::getPrice);
        System.out.println(price.orElse(BigDecimal.ZERO));

        System.out.println("summingInt、averagingInt");
        int stockSum = productList.stream().collect(Collectors.summingInt(Product::getStock));
        System.out.println(stockSum);

        System.out.println("join");
        String nameStr = productList.stream().map(Product::getName).collect(Collectors.joining(","));
        System.out.println(nameStr);

        System.out.println("groupBy");
        Map<Integer, List<Product>> mapList = productList.stream().collect(Collectors.groupingBy(Product::getStatus));
        mapList.forEach((k, v) -> System.out.println(k + "," + v));
        Map<Integer, Double> mapCount = productList.stream().collect(Collectors.groupingBy(Product::getStatus, Collectors.summingDouble(Product::getStock)));
        mapCount.forEach((k, v) -> System.out.println(k + "," + v));

        System.out.println("groupBy mapping");
        Map<Integer, List<String>> mappingList = productList.stream().collect(Collectors.groupingBy(Product::getStatus, Collectors.mapping(Product::getName, Collectors.toList())));
        mappingList.forEach((k, v) -> System.out.println(k + "," + v));

        System.out.println("partitioningBy");
        Map<Boolean, Map<Integer, List<Product>>> mapPartitioningBy = productList.stream().collect(Collectors.partitioningBy((p -> p.getStatus() == 1), Collectors.groupingBy(Product::getType)));
        mapPartitioningBy.forEach((k, v) -> System.out.println(k + "," + v));

        System.out.println("toMap");
        // Map map = productList.stream().collect(Collectors.toMap(i -> i.getName(), a -> a));
        Map map = productList.stream().collect(Collectors.toMap(i -> i.getName(), Function.identity(), (a, b) -> b));
        map.forEach((k, v) -> System.out.println(k + "," + v));

        System.out.println("toList");
        List list = productList.stream().map(Product::getStock).collect(Collectors.toList());
        list.forEach(i -> System.out.println(i));

        System.out.println("reducing");
        Comparator<Product> comparator = Comparator.comparing(Product::getStock);
        Function<Product, Product> mapper = p -> {
            Integer stockNum = p.getStock();
            p.setStock(stockNum + 100);
            p.setPrice(p.getPrice().add(new BigDecimal(100)));
            return p;
        };
        Product identity = new Product();
        identity.setStock(500);
        Product product = productList.stream().collect(Collectors.reducing(identity, mapper, BinaryOperator.maxBy(comparator)));
        System.out.println(product);


        Integer min = productList.stream().collect(Collectors.reducing(50, Product::getStock, Integer::min));
        System.out.println(min);
    }


    public class Product {
        private Long id;
        private String name;
        private BigDecimal price;
        private Integer stock;
        private Integer type; // 1：普通商品，2：系列品 3：组合品 4：子品
        private Integer status; // 上下架 1：上架 2：下架

        public Product() {

        }

        public Product(Long id, String name, BigDecimal price, Integer stock, Integer type, Integer status) {
            this.id = id;
            this.name = name;
            this.price = price;
            this.stock = stock;
            this.type = type;
            this.status = status;
        }

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public BigDecimal getPrice() {
            return price;
        }

        public void setPrice(BigDecimal price) {
            this.price = price;
        }

        public Integer getStock() {
            return stock;
        }

        public void setStock(Integer stock) {
            this.stock = stock;
        }

        public Integer getType() {
            return type;
        }

        public void setType(Integer type) {
            this.type = type;
        }

        public Integer getStatus() {
            return status;
        }

        public void setStatus(Integer status) {
            this.status = status;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Product product = (Product) o;
            return Objects.equals(id, product.id) &&
                    Objects.equals(name, product.name) &&
                    Objects.equals(price, product.price) &&
                    Objects.equals(stock, product.stock) &&
                    Objects.equals(type, product.type) &&
                    Objects.equals(status, product.status);
        }

        @Override
        public int hashCode() {
            return Objects.hash(id, name, price, stock, type, status);
        }

        @Override
        public String toString() {
            return "Product{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    ", price=" + price +
                    ", stock=" + stock +
                    ", type=" + type +
                    ", status=" + status +
                    '}';
        }
    }
}