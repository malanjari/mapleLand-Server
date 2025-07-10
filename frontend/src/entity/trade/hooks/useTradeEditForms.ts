import { useState, useEffect, useRef } from "react";
import { JariItem } from "@/entity/trade/model/type";

export function useTradeEditForm(item: JariItem, onClose: () => void) {
  const editBoxRef = useRef<HTMLFormElement>(null);
  const [editPrice, setEditPrice] = useState(item.price.toString());
  const [editComment, setEditComment] = useState(item.comment);
  const [editServerColor, setEditServerColor] = useState<
    "Red" | "Yellow" | "Green"
  >(item.serverColor as "Red" | "Yellow" | "Green");
  const [editNegotiationOption, setEditNegotiationOption] = useState(
    item.negotiationOption
  );

  useEffect(() => {
    const handleClickOutside = (event: MouseEvent) => {
      if (
        editBoxRef.current &&
        !editBoxRef.current.contains(event.target as Node)
      ) {
        onClose();
      }
    };
    document.addEventListener("mousedown", handleClickOutside);
    return () => document.removeEventListener("mousedown", handleClickOutside);
  }, [onClose]);

  return {
    editBoxRef,
    editPrice,
    editComment,
    editServerColor,
    editNegotiationOption,
    setEditPrice,
    setEditComment,
    setEditServerColor,
    setEditNegotiationOption,
  };
}
