import { RegisterNoticeBox } from "@/feature/register/ui/RegisterNoticeBox";
import { TradeTypeSelector } from "@/feature/register/ui/TradeTypeSelector";
import { MapPreview } from "@/feature/register/ui/MapPreview";
import { ServerColorSelector } from "@/feature/register/ui/ServerColorSelector";
import { PriceInput } from "@/feature/register/ui/PriceInput";
import { NegotiationToggle } from "@/feature/register/ui/NegotiationToggle";
import { CommentTextarea } from "@/feature/register/ui/CommentTextarea";
import { SubmitRegisterButton } from "@/feature/register/ui/SubmitRegisterButton";
import { useJariRegisterForm } from "@/feature/register/hooks/useJariRegisterForm";
const JariRegisterDetailPage = () => {
  const { form, setForm, mapData, formatToWonStyle, handleSubmit } =
    useJariRegisterForm();

  return (
    <div className="flex flex-col items-center pt-10 h-full gap-5 px-4 pb-20">
      {/* 안내 박스 */}
      <RegisterNoticeBox />

      {/* tradeType */}
      <TradeTypeSelector
        tradeType={form.tradeType}
        onSelect={(type) => setForm((prev) => ({ ...prev, tradeType: type }))}
      />

      {/* 거래 폼 */}
      {form.tradeType && (
        <div>
          {mapData && (
            <MapPreview
              mapName={mapData.mapName}
              miniMapImageUrl={mapData.miniMapImageUrl}
              miniMapImageLogoUrl={mapData.miniMapImageLogoUrl}
            />
          )}

          <ServerColorSelector
            serverColor={form.serverColor}
            onChange={(color) =>
              setForm((prev) => ({ ...prev, serverColor: color }))
            }
          />

          <PriceInput
            price={form.price}
            onChange={(val) => setForm((prev) => ({ ...prev, price: val }))}
            formatToWonStyle={formatToWonStyle}
          />

          <NegotiationToggle
            checked={form.negotiationOption}
            onChange={(checked) =>
              setForm((prev) => ({ ...prev, negotiationOption: checked }))
            }
          />

          <CommentTextarea
            comment={form.comment}
            onChange={(value) =>
              setForm((prev) => ({ ...prev, comment: value }))
            }
          />

          <SubmitRegisterButton onClick={handleSubmit} />
        </div>
      )}
    </div>
  );
};

export default JariRegisterDetailPage;
