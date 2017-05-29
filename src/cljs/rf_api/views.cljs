(ns rf-api.views
    (:require [re-frame.core :as re-frame]))

(defn get-user-name [user-name]
  [:div
    [:input {:type "text" :value @user-name :on-change #(re-frame/dispatch [:user-input-change (-> % .-target .-value)])}]
    [:input {:type "button" :value "Search" :on-click #(re-frame/dispatch [:search @user-name])}]])
(defn main-panel []
  (let [status (re-frame/subscribe [:status])
        user-name (re-frame/subscribe [:user-name-input])
        avatar-url (re-frame/subscribe [:avatar-url])]
    (fn []
      [:div "Status: " @status
        [:div [get-user-name user-name]]
        [:div "Current user name is " @user-name]
        (if (empty? @avatar-url) nil [:img {:src @avatar-url :height "200px"}])])))
