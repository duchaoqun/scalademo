## Chapter 18 高级类型

### 【Demo01】单例类型

### 【Demo02】类型投影

### 【Demo03】路径

### 【Demo04】类型别名

### 【Demo05】结构类型

### 【Demo06】复合类型

### 【Demo07】中置类型

### 【Demo08】存在类型

### 【Demo09】类型系统

- 类型：class trait，  语法： class C ...， trait C ...
- 类型：tuple      ，  语法： (T1, ..., Tn)
- 类型：function   ，  语法： (T1, ..., Tn) => T
- 类型：带注解的类型， 语法： T@A
- 类型：参数化类型，   语法： A[T1, ..., Tn]
- 类型：单例类型，     语法： 值.type
- 类型：类型投影，     语法： O#I
- 类型：符合类型，     语法： T1 with T2 with ... with Tn {声明}
- 类型：中置类型，     语法： T1 A T2
- 类型：存在类型，     语法： T forSome { type 和 val 声明}

### 【Demo10】自身类型

### 【Demo11】依赖注入

### 【Demo12】抽象类型

### 【Demo13】家族多态

### 【Demo14】高等类型 //TODO