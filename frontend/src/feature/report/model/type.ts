export interface ReportReason {
  reason: string;
  createTime: string;
  reportImageUrl: string;
}

export interface ReportedPost {
  userMapId: number;
  mapName: string;
  price: number;
  serverColor: string;
  area: string;
  comment: string;
  isCompleted: boolean;
  createTime: string;
  userId: number;
  userName: string;
  globalName: string;
  image: string;
  reasons: ReportReason[];
}

export interface ReportedPostsResponse {
  content: ReportedPost[];
  totalPages: number;
  totalElements: number;
  number: number;
  size: number;
  first: boolean;
  last: boolean;
  empty: boolean;
}
