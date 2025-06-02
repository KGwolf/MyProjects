2025-06-02:
    缓存框架到底应该怎么设计？
    缓存都是Key Value的形式。
    redis：Key必须都是String类型的。 然后Value有很多种类型，最常见的是String、Hash(相当于就是Map)。
    Caffeine：Key可以是任意对象Object，比如String、Integer等对象。 然后Value 也可以是任意的对象，并且可以直接存储和取出，不需要像redis那样需要进行反序列化。