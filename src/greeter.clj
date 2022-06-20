(ns greeter)

(defn greeting-for [nm]
  (cond
    (empty? nm)         "Hello, world!\n"
    :else               (str "Hello, " nm "\n")))
