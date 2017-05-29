(ns rf-api.subs
    (:require-macros [reagent.ratom :refer [reaction]])
    (:require [re-frame.core :as re-frame]))

(re-frame/reg-sub
 :status
 (fn [db]
   (:status db)))

(re-frame/reg-sub
 :avatar-url
 (fn [db]
   (:avatar-url db)))

(re-frame/reg-sub
 :user-name-input
 (fn [db]
   (:user-name-input db)))
