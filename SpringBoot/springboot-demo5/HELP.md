# SpringBoot原理解析
## java包
### HeaderConfig+HeadGenerator+HeaderParser
- 在配置类中配置bean，当别的包使用该jar包时根据条件自动注入
- 根据不同条件自动注入

### MyImportSelector
- 返回需要注入在别的工程中的类的全类名数组（可选择多个配置类）

### EnableHeaderConfig
- 别的工程中启动使用该注解指定需要注入的Bean(MyImportSelector)来自动注入